package view;

import java.util.List;
import model.Histogram;
import model.Mail;


public class MailHistogramBuilder {
    public static Histogram<String> build (List<Mail> mailList) {
        Histogram<String> histogram = new Histogram<>();
        for (Mail mail : mailList) 
            histogram.increment(mail.getDomain());

        return histogram;
    }
    
    public static Histogram<String> buildString (List<String> mailList) {
        Histogram<String> histogram = new Histogram<>();
        for (String mail : mailList) 
            histogram.increment(mail.substring(mail.lastIndexOf("@")+1));
        
        return histogram;
    }
}
