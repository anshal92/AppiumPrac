package enums;

public enum DriverType {
    ANDROID("UiAutomator2"),
    IOS("XCUITest");

    final String DriverType;

    DriverType(String driverType){
        this.DriverType = driverType;
    }
}
