package web.rulemanage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // 禁用CSRF保护
                .authorizeRequests()
                .anyRequest().permitAll() // 允许所有请求
                .and()
                .httpBasic().disable(); // 禁用HTTP Basic认证
        return http.build();
    }
}
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // 禁用CSRF保护
//                .authorizeRequests()
//                .requestMatchers("/user/login", "/user/register"
//                        , "/baicucheck_content","/companies/*","/Companyinfo/*",
//                        "/Complianceapplication/*","/check-content/*","/send/*",
//                        "/Documents/*","/Eprdeclaration1/*","/Eprdeclaration/*",
//                        "/Eprregistration/*","/Eprregistrationservicedata/*",
//                        "/Eprservice/*","/Eudeclarationofconformity/*",
//                        "/api/download/images/{fileName}","/api/upload/sales-data/{fileName}",
//                        "/google/*","/hmrc/*","/image-content-check/image","/Importbyfood/*",
//                        "/Importbyhuaxuepin/*","/Importbyjixie/*","/Importbyyuancailiao/*","/Localtaxpolicy/*","/News/*","/Packagingsummarydeclaration/*",
//                        "/Products/*","/Taxdeclaration/*","/Taxpayment/*","/Taxpaymentnext/*","/Taxrefund/*","/Taxservice/*","/Todos/*","/vat-check/lookup/{vatNumber}",
//                        "/vat/{vatNumber}/obligations","/Vatdeclarationdetails/*","/vat-checkeu/check","/api/vat-payments/{paymentId}","/vies/check-status","/Workorder/*",
//                        "/doc.html"
//                ).permitAll()
//                .anyRequest().authenticated() // 其他所有请求都需要认证
//                .and()
//                .httpBasic().disable(); // 禁用HTTP Basic认证
//
//        return http.build();
//    }
//}
