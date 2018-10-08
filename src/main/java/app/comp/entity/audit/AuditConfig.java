package app.comp.entity.audit;


import app.comp.service.implementations.CompanyServiceImpl;
import app.comp.service.interfaces.CompanyService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration

//Планировка задачь
@EnableScheduling
@EnableAsync //Асинхрон


@EnableWebMvc
@PropertySource({"classpath:db.properties"})
public class AuditConfig {

    private Environment env;
//
//    @Autowired
//    public void setEnv(Environment env) {
//        this.env = env;
//    }
//
//    @Bean
//    public PropertyEditorRegistrar[] propertyEditorRegistrarsList() {
//        List<PropertyEditorRegistrar> propertyEditor = new ArrayList<>();
//        propertyEditor.add(new DateTimeEditorRegistrar(env.getProperty("date.format.pattern")));
//        return propertyEditor.toArray(new PropertyEditorRegistrar[propertyEditor.size()]);
//    }
//
//    @Bean
//    public CustomEditorConfigurer customEditorConfigurer() {
//        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
//        customEditorConfigurer.setPropertyEditorRegistrars(propertyEditorRegistrarsList());
//        return customEditorConfigurer;
//    }
//
//
//    @Bean
//    public ConversionServiceFactoryBean conversionServiceFactoryBean() {
//        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
//        Set<Converter> converters = new HashSet<>();
//        converters.add(new StringToDateTimeConvert());
//        conversionServiceFactoryBean.setConverters(converters);
//        return conversionServiceFactoryBean;
//    }

    @Bean(name = "/company")
    public HttpInvokerServiceExporter companyExporter() {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(new CompanyServiceImpl());
        httpInvokerServiceExporter.setServiceInterface(CompanyService.class);
        return httpInvokerServiceExporter;
    }


    public static void main(String[] args) {
        SpringApplication.run(AuditConfig.class, args);
    }

}
