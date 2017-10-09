package annotAndReflectLection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Meyttt on 08.10.2017.
 */
@XmlType
public class SimpleJAXB {
    @XmlElement(name = "Name")
    protected String name;

}
