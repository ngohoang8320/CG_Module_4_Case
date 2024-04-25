package com.codegym.configuration;

public class WebSecurityConfig {
    /*@Configuration
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private MyUserDetailServiceImpl userDetailService;

        @Bean
        public BCryptPasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailService)
                    .passwordEncoder(passwordEncoder());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .formLogin()
                    .defaultSuccessUrl("/student").permitAll()
                    .and().authorizeRequests()
                    .anyRequest().authenticated();
        }*/
}
