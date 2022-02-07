package br.com.nunes.estudos;

public class ComposicaoHeranca {

    public static void main(String[] args) {
        Transport transport1 = new Transport(new CombustionEngine(), new Human());
        Transport transport2 = new Transport(new EletricEngine(), new Robot());
        transport1.deliver(new Destination("Taguatinga "), new Cargo("PlayStation 5"));
        transport2.deliver(new Destination("Japão "), new Cargo("Coxinha"));

    }


    static class Transport{
        private Engine e;
        private Driver d;

        Transport(Engine e, Driver d){
            this.e = e;
            this.d = d;
        }
        private void deliver(Destination destination, Cargo cargo) {
            System.out.println("Enviando carga: "+cargo.carga+ " pro destino: "+destination.destino);
            e.move();
            d.navigate();
        }


        @Override
        public String toString() {
            return "Transport{" +
                    "e=" + e +
                    ", d=" + d +
                    '}';
        }
    }

    interface Engine {
        void move();
    }

    interface Driver {
        void navigate();
    }

    static class CombustionEngine implements Engine {
        @Override
        public void move() {
            System.out.println("Movendo com gasolina");
        }
    }

    static class EletricEngine implements Engine {
        @Override
        public void move() {
            System.out.println("Movendo com energia");
        }
    }

    static class Robot implements Driver{
        @Override
        public void navigate() {
            System.out.println("Pilotado por um robo");
        }

    }

    static class Human implements Driver {
        @Override
        public void navigate() {
            System.out.println("Pilotatado por um humano");
        }
    }

    static class Destination {
        String destino;
        Destination(String destination){
            this.destino = destination;
        }
    }

    static class Cargo {
        String carga;
        Cargo(String cargo){
            this.carga = cargo;
        }
    }
}
