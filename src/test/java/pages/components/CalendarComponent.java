package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1993");
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text("18")).click();
        //$(".react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month)").click();
    }
}
