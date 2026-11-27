package data;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;

public class LocalDataAdapter extends XmlAdapter<String,LocalDate> {
    @Override
    public LocalDate unmarshal(String o) throws Exception {
        return LocalDate.ofYearDay(2000,100);
    }

    @Override
    public String marshal(LocalDate o) throws Exception {
        if (o instanceof LocalDate tmp) {
           return String.format("%4d-%2d-%2d", tmp.getYear(), tmp.getMonthValue(), tmp.getDayOfMonth());
        } else {
            return "2000-01-01";
        }

    }
}
