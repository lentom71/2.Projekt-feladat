package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student
{
    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void grading(Mark mark)
    {
        if (mark == null)
        {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }
                                                                                             // érdemjegy rögzítése

    public double calculateAverage()
    {
        int szamlalo = 0;
        int szamok = 0;
        for( Mark mark : marks )
        {
            szamok = szamok + mark.getMarkType().getValues();
            szamlalo++;
        }
        double atlag = szamok/szamlalo;
        return atlag;
    }                                                                                        // teljes átlag számolása

    public double calculateSubjectAverage(Subject subject)
    {
        if (subject == null)
        {
            throw new NullPointerException("Subject must not be null");
        }
        int sum =0;
        int counter = 0;
        for (Mark mark : marks)
        {
            if (mark.getSubject().equals(subject))
            {
                sum += mark.getMarkType().getValues();
                counter++;
            }
        }
        if (counter>0)
        {
            return  sum/counter;
        }
        return 0.0;
    }                                                                                         // tantárgyhoz tartozó átlag számítása

    public String toString()
    {
        StringBuilder builder = new StringBuilder(500);
        builder.append(name + " marks: ");
        for (Mark mark : marks)
        {
            builder.append(String.format("%s: %s(%d) ",
                    mark.getSubject().getSubjectName(),
                    mark.getMarkType().getDescription(),
                    mark.getMarkType().getValues()));

        }
        return builder.toString().trim();
    }

    private boolean isEmpty(String name)
    {
        return  (name == null || name.isBlank());
    }


}
