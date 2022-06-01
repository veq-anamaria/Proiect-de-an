package iterator;

public class MailRepository implements Container{
    public String mail[] = {"vechiu.anamaria@gmail.com" , "adomnita.alex@gmail.com" ,"vechiu.otilia@gmail.com" };

    @Override
    public Folowing getFolowing() {
        return new EmailFolowing();
    }

    private class EmailFolowing implements Folowing {

        int index;

        @Override
        public boolean theNext() {

            if(index < mail.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if(this.theNext()){
                return mail[index++];
            }
            return null;
        }
    }

}
