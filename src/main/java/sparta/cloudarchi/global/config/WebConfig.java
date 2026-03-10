package sparta.cloudarchi.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sparta.cloudarchi.global.interceptor.ApiLogInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiLogInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns(
                        "/actuator/**",
                        "/h2-console/**",
                        "/error"
                );
    }
}