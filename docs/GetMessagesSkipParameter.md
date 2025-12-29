

# GetMessagesSkipParameter

## anyOf schemas
* [Integer](Integer.md)
* [String](String.md)

## Example
```java
// Import classes:
import io.devinbox.client.model.GetMessagesSkipParameter;
import io.devinbox.client.model.Integer;
import io.devinbox.client.model.String;

public class Example {
    public static void main(String[] args) {
        GetMessagesSkipParameter exampleGetMessagesSkipParameter = new GetMessagesSkipParameter();

        // create a new Integer
        Integer exampleInteger = new Integer();
        // set GetMessagesSkipParameter to Integer
        exampleGetMessagesSkipParameter.setActualInstance(exampleInteger);
        // to get back the Integer set earlier
        Integer testInteger = (Integer) exampleGetMessagesSkipParameter.getActualInstance();

        // create a new String
        String exampleString = new String();
        // set GetMessagesSkipParameter to String
        exampleGetMessagesSkipParameter.setActualInstance(exampleString);
        // to get back the String set earlier
        String testString = (String) exampleGetMessagesSkipParameter.getActualInstance();
    }
}
```


