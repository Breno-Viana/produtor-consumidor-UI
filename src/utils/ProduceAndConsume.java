package utils;

public class ProduceAndConsume {
    private final Buffer<Product> buffer;

    public ProduceAndConsume(Buffer<Product> buffer) {
        this.buffer = buffer;
    }

    public void produce() {
        int productP = 0;
        while (true) {
            synchronized (this) {
                while (buffer.isFull()) {
                    try {
                        System.out.println("Fila cheia, produtor esperando");
                        wait();
                    } catch (InterruptedException ignored) {
                    }
                }

                    Product product = new Product(productP);
                    buffer.getBuffer().add(product);
                    System.out.println("Produzido: " + product);
                    notify();
                    productP++;

            }
        }
    }

    public void consume() {
        while (true) {
            synchronized (this) {
                while (buffer.getBuffer().isEmpty()) {
                    try {
                        System.out.println("Fila vazia, consumidor esperando");
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("consumidor consumiu: " + buffer.getBuffer().remove());
                notify();

            }
        }
    }
}