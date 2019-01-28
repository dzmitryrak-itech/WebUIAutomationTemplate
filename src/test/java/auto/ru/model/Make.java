package auto.ru.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * https://plugins.jetbrains.com/plugin/6317-lombok-plugin
 * https://dzone.com/articles/5-tips-for-using-lombok-in-production
 */
@Data
@AllArgsConstructor
public class Make {
    String name;
    String parentCategory;
}
