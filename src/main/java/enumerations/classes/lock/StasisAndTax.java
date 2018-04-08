package enumerations.classes.lock;

public enum StasisAndTax {
  ACTIVED( "ACTIVED" ),
  ATTACK( "ATTACK" ),
  BATTLEFIELD( "BATTLEFIELD" ),
  CANT( "CAN'T" ),
  CAST( "CAST" ),
  COST( "COST" ),
  ENTER( "ENTER" ),
  MORE( "MORE" ),
  OPPONENTS( "OPPONENTS" ),
  PAYS( "PAYS" ),
  TAPPED( "TAPPED" ),
  UNLESS( "UNLESS" );

  private String value;

  StasisAndTax( String value ) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
