
package votacao.eletronica.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.13
 * Fri Dec 25 12:34:09 GMT 2020
 * Generated source version: 2.6.13
 */

@XmlRootElement(name = "tempoRestanteSessaoResponse", namespace = "http://eletronica.votacao/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tempoRestanteSessaoResponse", namespace = "http://eletronica.votacao/")

public class TempoRestanteSessaoResponse {

    @XmlElement(name = "return")
    private java.lang.String _return;

    public java.lang.String getReturn() {
        return this._return;
    }

    public void setReturn(java.lang.String new_return)  {
        this._return = new_return;
    }

}

