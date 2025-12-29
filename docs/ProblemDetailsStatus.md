

# ProblemDetailsStatus

## anyOf schemas
* [Integer](Integer.md)
* [String](String.md)

NOTE: this class is nullable.

## Example
```java
// Import classes:
import io.devinbox.client.model.ProblemDetailsStatus;
import io.devinbox.client.model.Integer;
import io.devinbox.client.model.String;

public class Example {
    public static void main(String[] args) {
        ProblemDetailsStatus exampleProblemDetailsStatus = new ProblemDetailsStatus();

        // create a new Integer
        Integer exampleInteger = new Integer();
        // set ProblemDetailsStatus to Integer
        exampleProblemDetailsStatus.setActualInstance(exampleInteger);
        // to get back the Integer set earlier
        Integer testInteger = (Integer) exampleProblemDetailsStatus.getActualInstance();

        // create a new String
        String exampleString = new String();
        // set ProblemDetailsStatus to String
        exampleProblemDetailsStatus.setActualInstance(exampleString);
        // to get back the String set earlier
        String testString = (String) exampleProblemDetailsStatus.getActualInstance();
    }
}
```


