package votacao.eletronica;

public class ExampleDocument {
    private String _id = "example_id";
    private String _rev = null;
    private boolean isExample;
    private String value;
    public ExampleDocument(boolean isExample,String v) {
      this.isExample = isExample;
      this.value = v;
    }

    public String toString() {
      return "{ id: " + _id + ",\nrev: " + _rev + ",\nvalue: " + value + ",\nisExample: " + isExample + "\n}";
    }
  }
