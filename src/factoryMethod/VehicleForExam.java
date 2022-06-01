package factoryMethod;

enum TypeVehicle {
    Motorcycle, Truck, Car
}
enum Gearbox{
    Auto, Mechanic
}

abstract class VehicleForExam {
    VehicleForExam(TypeVehicle typeVehicle, Gearbox gearbox){
        this.typeVehicle = typeVehicle;
        this.gearbox = gearbox;
    }
    abstract void construct();
    TypeVehicle typeVehicle = null;
    Gearbox gearbox= null;

    TypeVehicle getType()
    {
        return typeVehicle;
    }
    void setType(TypeVehicle typeVehicle)
    {
        this.typeVehicle = typeVehicle;
    }
    @Override
    public String toString()
    {
        return "This-" +typeVehicle + " it's prepared for exam.";
    }
}
class Cars extends VehicleForExam {
    Cars(Gearbox gearbox) {
        super(TypeVehicle.Car, gearbox);
        construct();
    }
    @Override
    protected void construct() {
        System.out.println("Use a car for exam.");
    }
}
class Motorcycles extends VehicleForExam {
    Motorcycles( Gearbox gearbox) {
        super( TypeVehicle.Motorcycle, gearbox);
        construct();
    }
    @Override
    protected void construct() {
        System.out.println("Use a motorcycle for exam.");
    }
}
class Trucks extends VehicleForExam {
    Trucks( Gearbox gearbox) {
        super( TypeVehicle.Truck, gearbox);
        construct();
    }
    @Override
    protected void construct() {
        System.out.println("Use a truck for exam.");
    }
}

class GearboxType {
    static VehicleForExam  buildVehicleForExam(TypeVehicle typeVehicle)
    {
        VehicleForExam vehicleForExam = null;
        switch (typeVehicle)
        {
            case Car:
                vehicleForExam= new Cars(Gearbox.Auto);
                break;
            case Motorcycle:
                vehicleForExam = new Motorcycles(Gearbox.Mechanic);
                break;
            case Truck:
                vehicleForExam = new Trucks(Gearbox.Mechanic);
                break;
            default:
                break;
        }

        return vehicleForExam;
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(GearboxType.buildVehicleForExam(TypeVehicle.Motorcycle));
        System.out.println(GearboxType.buildVehicleForExam(TypeVehicle.Car));
        System.out.println(GearboxType.buildVehicleForExam(TypeVehicle.Truck));
    }
}

