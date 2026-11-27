package data;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;

public class LocalDataAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String o) throws Exception {
        LocalDate ret;
        try {
            String[] felder = o.split("-");
            int jahr = Integer.parseInt(felder[0]);
            int monat = Integer.parseInt(felder[1]);
            int tag = Integer.parseInt(felder[2]);
            ret = LocalDate.of(jahr,monat,tag);
        } catch (Exception e) {
            ret= LocalDate.of(1970,1,1);
        }
        return ret;
    }

    @Override
    public String marshal(LocalDate o) throws Exception {
        return String.format("%04d-%02d-%02d", o.getYear(), o.getMonthValue(), o.getDayOfMonth());
    }
}
