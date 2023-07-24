package testdouble.entity;


import org.conacry.caero.domain.entity.Model;
import util.generator.StringGenerator;

public final class ModelStub {

    public static Model getModel() {
        return Model.from(StringGenerator.getRandomString());
    }
}
