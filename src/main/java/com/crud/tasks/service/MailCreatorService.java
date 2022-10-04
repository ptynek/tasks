package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Service
public class MailCreatorService {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private AdminConfig adminConfig;

    private String companyName = "Company name";
    private String companyEmail = "CompanyEmail@gmail.com";
    private String companyPhone = "666666666";

    public String buildTrelloCardEmail(String message){
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("company_details", adminConfig.getCompanyName() + "<br>"
                + adminConfig.getCompanyEmail() + "<br>" + adminConfig.getCompanyPhone());
/*        context.setVariable("company_details", companyName + "<br>"
                + companyEmail+ "<br>" + companyPhone);*/
        context.setVariable("good_bye", "Have a nice day!");
        return templateEngine.process("mail/created-trello-card-mail", context);
    }
}
