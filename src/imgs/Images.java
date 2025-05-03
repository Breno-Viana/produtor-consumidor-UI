package imgs;

import javafx.scene.image.Image;

public class Images {
    private static final Image EMPLOYEE_WITH_BOX = new Image("./imgs/funcionario-com-caixa.png");
    private static final Image EMPLOYEE_WITHOUT_BOX  = new Image("./imgs/funcionario-sem-caixa.png");
    private static final Image COSTUMER_WITH_BOX = new Image("./imgs/cliente-com-caixa.png");
    private static final Image COSTUMER_WITHOUT_BOX = new Image("./imgs/cliente-sem-caixa.png");
    private static final Image BOX = new Image("./imgs/caixa.png");
    private static final Image VOID = new Image("./imgs/img.png");

    public static Image GET_EMPLOYEE_WITH_BOX() {
        return EMPLOYEE_WITH_BOX;
    }

    public static Image GET_EMPLOYEE_WITHOUT_BOX() {
        return EMPLOYEE_WITHOUT_BOX;
    }
    public static Image GET_COSTUMER_WITH_BOX() {
        return COSTUMER_WITH_BOX;
    }

    public static Image GET_COSTUMER_WITHOUT_BOX() {
        return COSTUMER_WITHOUT_BOX;
    }

    public static Image GET_BOX() {
        return BOX;
    }

    public static Image GET_VOID() {
        return VOID;
    }


}
