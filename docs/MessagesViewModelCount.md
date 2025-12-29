

# MessagesViewModelCount

Total number of messages in the mailbox

## anyOf schemas
* [Integer](Integer.md)
* [String](String.md)

## Example
```java
// Import classes:
import io.devinbox.client.model.MessagesViewModelCount;
import io.devinbox.client.model.Integer;
import io.devinbox.client.model.String;

public class Example {
    public static void main(String[] args) {
        MessagesViewModelCount exampleMessagesViewModelCount = new MessagesViewModelCount();

        // create a new Integer
        Integer exampleInteger = new Integer();
        // set MessagesViewModelCount to Integer
        exampleMessagesViewModelCount.setActualInstance(exampleInteger);
        // to get back the Integer set earlier
        Integer testInteger = (Integer) exampleMessagesViewModelCount.getActualInstance();

        // create a new String
        String exampleString = new String();
        // set MessagesViewModelCount to String
        exampleMessagesViewModelCount.setActualInstance(exampleString);
        // to get back the String set earlier
        String testString = (String) exampleMessagesViewModelCount.getActualInstance();
    }
}
```


