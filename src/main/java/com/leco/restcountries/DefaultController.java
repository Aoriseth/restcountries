package com.leco.restcountries;

import com.leco.restcountries.Entities.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class DefaultController {

//   @Autowired
//   private CountryRepository countryRepository;

    private static final Logger log = LoggerFactory.getLogger(RestcountriesApplication.class);



    RestTemplate restTemplate = new RestTemplate();

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    // Index mapping
    @RequestMapping
    public String index(){
        return "index";
    }

    // Find GET mapping
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public String first(@RequestParam(value="countryCode", required=false, defaultValue="be") String countryCode, Model model) {
        model.addAttribute("countryCode", countryCode);
        model.addAttribute("country", new Country());
        return "find";
    }

    // Find POST mapping -> request info from restcountries API using RestTemplate
    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public String findSubmit(@RequestParam("countryCode") String countryCode, Model model){
        Country country = new Country();
        String res = "https://restcountries.eu/rest/v2/alpha/"+
                countryCode+
                "?fields=name;capital;currencies;flag;callingcodes;population;rates";
        log.info(res);
        try {
            country = restTemplate.getForObject(
                    "https://restcountries.eu/rest/v2/alpha/"+ countryCode +"?fields=name;capital;currencies;flag;callingCodes;population;rates", Country.class);

        }
        catch (Exception e){
            log.info(e.toString());

        }
//        Rates rates = new Rates();
//        try {
//            rates = restTemplate.getForObject("http://api.fixer.io/latest?symbols="+ country.getCurrencies().get(0).getCode(), Rates.class);
//            country.setRates(rates);
//        }
//        catch (Exception e){
//            log.info(e.toString());
//        }

            log.info(country.toString()); // Logging country information
            model.addAttribute("country",country);

        return "find";
    }

}
