package javaTdd.chap04_hilogame.dependencies;

public class SecretNumberStub implements RandomNumberGenerator{
    @Override
    public int createSecretNumber(int upperLimit) {
        return upperLimit/2;
    }
}
