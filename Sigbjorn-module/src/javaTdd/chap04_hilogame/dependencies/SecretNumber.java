package javaTdd.chap04_hilogame.dependencies;

public class SecretNumber implements RandomNumberGenerator{
    @Override
    public int createSecretNumber(int upperLimit) {
        return 1 + (int)(Math.random() * upperLimit);
    }
}
