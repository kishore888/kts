package com.hospitality.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = "com.hospitality.config")
public class SpringConfig extends WebMvcConfigurerAdapter{
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();

    }
	
//	 /**
//     * Configure TilesConfigurer.
//     */
//    @Bean
//    public TilesConfigurer tilesConfigurer(){
//        TilesConfigurer tilesConfigurer = new TilesConfigurer();
//        tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
//        tilesConfigurer.setCheckRefresh(true);
//        return tilesConfigurer;
//    }
// 
//    /**
//     * Configure ViewResolvers to deliver preferred views.
//     */
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        TilesViewResolver viewResolver = new TilesViewResolver();
//        registry.viewResolver(viewResolver);
//    }
     
    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/AdminLte/**,").addResourceLocations("/AdminLte/**","/images/**");
//        registry.addResourceHandler("/images/**,").addResourceLocations("/AdminLte/**","/images/**");
        registry.addResourceHandler("/AdminLte/**,/images/**,/matrixAdmin/**,/js/**,/css/**,").addResourceLocations("/AdminLte/**","/images/**","/matrixAdmin/**","/js/**","/css/**");
    }

}
