
package votacao.eletronica.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.13
 * Sat Jan 09 00:07:22 GMT 2021
 * Generated source version: 2.6.13
 */

@XmlRootElement(name = "votanteAtivo", namespace = "http://eletronica.votacao/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "votanteAtivo", namespace = "http://eletronica.votacao/")

public class VotanteAtivo {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

}

