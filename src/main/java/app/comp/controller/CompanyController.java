package app.comp.controller;


import app.comp.entity.data.Company;
import app.comp.entity.data.Region;
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

//            List<Sort> collect = dataTable.getOrder()
//                    .stream()
//                    .map(o -> new Sort(o.getDir(), dataTable.getColumns().get(o.getColumn()).getName()))
//                    .collect(Collectors.toList()); Sort.by(collect);
//            return service.findAllByPage(PageRequest.of(start / length, length));
//

            List<Sort.Order> collect = dataTable.getOrder()
                    .stream()
                    .map(o -> new Sort.Order(o.getDir(), dataTable.getColumns().get(o.getColumn()).getData()))
                    .collect(Collectors.toList());

            List<DataTable.Column> collect1 = dataTable.getColumns().stream().filter(DataTable.Column::isSearchable).collect(Collectors.toList());
//            String nameRu = collect1.stream().filter(c -> c.getName().equals("nameRu")).findFirst().orElse(new DataTable.Column()).getSearch().getValue();
            Optional<DataTable.Column> nameRu1 = collect1.stream().filter(c -> c.getData().equals("nameRu")).findFirst();
//            String bin = collect1.stream().filter(c -> c.getName().equals("bin")).findFirst().orElse(new DataTable.Column()).getSearch().getValue();
            Optional<DataTable.Column> bin1 = collect1.stream().filter(c -> c.getData().equals("bin")).findFirst();
            String s1 = bin1.map(b -> b.getSearch().getValue()).orElse("");

            String s = nameRu1.map(o -> o.getSearch().getValue()).orElse("");
            Iterable<Region> all = regionService.getAll();
//
//            return service.findCompaniesByNameRuIsLikeAndBinLike(s, s1,
//                    PageRequest.of(dataTable.getStart() / dataTable.getLength(), dataTable.getLength(), Sort.by(collect)));
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


//    @RequestMapping(value = {"/{id}"}, params = "form", method = RequestMethod.POST)
//    public String update(@Valid Company company,
//                         BindingResult bindingResult,
//                         Model model,
//                         HttpServletRequest request,
//                         Locale locale,
//                         RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("message",
//                    new ViewMessage("error",
//                            messageSource.getMessage("validation.company.update.fail",
//                                    new Object[]{}, locale)));
//            model.addAttribute("company", company);
//            return "updateCompany";
//        }
//        model.asMap().clear();
//        redirectAttributes.addFlashAttribute("message",
//                new ViewMessage("success",
//                        messageSource.getMessage("validation.company.update.success",
//                                new Object[]{}, locale)));
//        service.saveCompany(company);
//        return "redirect:/companies/" + UrlUtil.encodeUrlPathSegment(String.valueOf(company.getId()), request);
//    }
//
//    @RequestMapping(value = {"/{id}"}, params = "form", method = RequestMethod.GET)
//    public String updateForm(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("company", service.findById(id));
//        return "updateCompany";
//    }
//
//
//    @RequestMapping(params = "form", method = RequestMethod.POST)
//    public String create(@Valid Company company,
//                         BindingResult bindingResult,
//                         Model model,
//                         HttpServletRequest request,
//                         Locale locale,
//                         RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("message",
//                    new ViewMessage("error",
//                            messageSource.getMessage("validation.company.save.fail",
//                                    new Object[]{}, locale)));
////            return "createCompany";
//            return "updateCompany";
//        }
//        model.asMap().clear();
//        redirectAttributes.addFlashAttribute("message",
//                new ViewMessage("success",
//                        messageSource.getMessage("validation.company.save.success",
//                                new Object[]{}, locale)));
//        service.saveCompany(company);
//        return "redirect:/companies/" + UrlUtil.encodeUrlPathSegment(String.valueOf(company.getId()),
//                request);
//
//    }
//
//
//    @RequestMapping(params = "form", method = RequestMethod.GET)
//    public String createForm(Model model) {
//        Company company = new Company();
//        model.addAttribute("company", company);
////        return "createCompany";
//        return "updateCompany";
//
//    }

}
