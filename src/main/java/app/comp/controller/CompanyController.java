package app.comp.controller;


import app.comp.entity.data.Company;
import app.comp.entity.system.DataTable;
import app.comp.service.interfaces.CompanyService;
import app.comp.service.interfaces.RegionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService service;
    private RegionService regionService;
    private MessageSource messageSource;


    @Autowired
    public void setRegionService(RegionService regionService) {
        this.regionService = regionService;
    }

    @Autowired
    public void setService(CompanyService service) {
        this.service = service;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @GetMapping(params = {"page", "size"}, produces = MediaType.TEXT_HTML_VALUE)
    public String getCompaniesTemplate(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                       @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                       Model model) {
        model.addAttribute("data", service.findAllByPage(PageRequest.of(page, size)));
        return "templates/companies :: companiesFragment";
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Company> getCompanies(@RequestParam(value = "start", required = false, defaultValue = "0") int start,
                                      @RequestParam(value = "length", required = false, defaultValue = "10") int length) {
        return service.findAllByPage(PageRequest.of(start / length, length));
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Company> getCompaniesDataTable(@RequestBody JsonNode data) {
        try {
            DataTable dataTable = new ObjectMapper().treeToValue(data, DataTable.class);
            List<Sort.Order> collect = dataTable.getOrder()
                    .stream()
                    .map(o -> new Sort.Order(o.getDir(), dataTable.getColumns().get(o.getColumn()).getData()))
                    .collect(Collectors.toList());

            List<DataTable.Column> collect1 = dataTable.getColumns().stream().filter(DataTable.Column::isSearchable).collect(Collectors.toList());
            Optional<DataTable.Column> nameRu1 = collect1.stream().filter(c -> c.getData().equals("nameRu")).findFirst();
            Optional<DataTable.Column> bin1 = collect1.stream().filter(c -> c.getData().equals("bin")).findFirst();
            String s1 = bin1.map(b -> b.getSearch().getValue()).orElse("");
            String s = nameRu1.map(o -> o.getSearch().getValue()).orElse("");
            return service.findCompaniesByNameRuIsLikeAndBinLike(s, s1,
                    PageRequest.of(dataTable.getStart() / dataTable.getLength(), dataTable.getLength(), Sort.by(collect)));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    @GetMapping(value = {"/{id}"}, consumes = "text/html", produces = "text/html")
    public String getCompany(@PathVariable("id") long id, Model model) {
        model.addAttribute("data", service.findById(id));
        return "templates/company :: companyFragment";
    }

    @GetMapping(value = {"/{id}"}, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Company getCompany(@PathVariable("id") long id) {
        return service.findById(id);
    }

//
//    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Page<View.AJAXCompanyRu> getCompanies(@RequestParam(value = "start", required = false, defaultValue = "0") int start,
//                                                 @RequestParam(value = "length", required = false, defaultValue = "10") int length) {
//        Page<View.AJAXCompanyRu> allRuEnByPage = service.findAllRuEnByPage(1L, PageRequest.of(start / length, length));
//
//        return  allRuEnByPage;
//    }


}
