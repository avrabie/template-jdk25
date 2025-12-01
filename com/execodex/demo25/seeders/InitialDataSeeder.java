@Configuration
public class InitialDataSeeder {
    @Bean
    public CommandLineRunner initData(){
        return args -> {
            System.out.println("Hello World");
        };
    }
}
