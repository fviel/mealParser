import java.time.LocalDate;
import java.time.LocalTime;

public class EntryDto {

    private Integer id; 
    private Integer user_id;
    private Integer age;
    private Double user_weight;
    private String name;
    private Double price; //change be BigDecimal//ok
    private Integer weight; 
    private Integer calories;
    private Double fat;
    private Double carbs;
    private Double protein;
    private LocalTime time_consumed;
    private LocalDate date_consumed;
    private String type;
    private boolean favorite;
    private String procedence ;
    
}
