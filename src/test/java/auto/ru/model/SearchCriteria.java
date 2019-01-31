package auto.ru.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

//TODO Additional params should be set here
@Data
@Builder
public class SearchCriteria {
    Make make;
    ArrayList<Model> models;
    boolean searchClickedAutomatically;
}
