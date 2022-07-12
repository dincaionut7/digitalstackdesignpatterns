package network.commands;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetDateTimeCommand implements Command{
    DateTimeFormatter dateFormatter;
    LocalDateTime date;

    public GetDateTimeCommand()
    {
       date =  LocalDateTime.now();
       dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }
    @Override
    public synchronized String execute() {
        return dateFormatter.format(date);
    }
}
