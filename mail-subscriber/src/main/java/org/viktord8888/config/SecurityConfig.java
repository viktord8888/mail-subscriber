package org.viktord8888.config;

//@Configuration
//@EnableWebSecurity(debug = true)
class SecurityConfig {
//class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private final BasicAuthenticationEntryPoint authenticationEntryPoint;
//
//    public SecurityConfig(BasicAuthenticationEntryPoint authenticationEntryPoint) {
//        this.authenticationEntryPoint = authenticationEntryPoint;
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password(passwordEncoder().encode("user1Pass"))
//                .authorities("ROLE_USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors();
//        http.csrf().disable();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests()
//                .antMatchers("/h2-console").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .authenticationEntryPoint(authenticationEntryPoint);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
