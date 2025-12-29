

# MessageCountResultCount

Number of messages in the mailbox

## anyOf schemas
* [Integer](Integer.md)
* [String](String.md)

## Example
```java
// Import classes:
import io.devinbox.client.model.MessageCountResultCount;
import io.devinbox.client.model.Integer;
import io.devinbox.client.model.String;

public class Example {
    public static void main(String[] args) {
        MessageCountResultCount exampleMessageCountResultCount = new MessageCountResultCount();

        // create a new Integer
        Integer exampleInteger = new Integer();
        // set MessageCountResultCount to Integer
        exampleMessageCountResultCount.setActualInstance(exampleInteger);
        // to get back the Integer set earlier
        Integer testInteger = (Integer) exampleMessageCountResultCount.getActualInstance();

        // create a new String
        String exampleString = new String();
        // set MessageCountResultCount to String
        exampleMessageCountResultCount.setActualInstance(exampleString);
        // to get back the String set earlier
        String testString = (String) exampleMessageCountResultCount.getActualInstance();
    }
}
```


