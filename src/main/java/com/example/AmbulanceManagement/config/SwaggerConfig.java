package com.example.AmbulanceManagement.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

//    @Bean
//    public OpenAPI openAPI() {
//        String schemeName = "bearerScheme";
//        return new OpenAPI()
//                .addSecurityItem(
//                        new SecurityRequirement().addList(schemeName)
//                )
//                .components(
//                        new Components().addSecuritySchemes(
//                                schemeName
//                                , new SecurityScheme()
//                                        .name(schemeName)
//                                        .type(SecurityScheme.Type.HTTP)
//                                        .bearerFormat("JWT")
//                                        .scheme("bearer")
//                        )
//                )
//                .info(getInfo());
//    }


//    private Info getInfo() {
//
//        Contact contact = new Contact();
//        contact.setEmail("ndmorkar@gmail.com");
//        contact.setName("Nilesh Morkar");
//        contact.setUrl("https://www.google.com/");
//        return new Info()
//                .title("Hospital Management Backend")
//                .description()
//                .contact(contact)
//                .version("v0.0.1")
//                .summary("Welcome !!!!!");
//    }
}