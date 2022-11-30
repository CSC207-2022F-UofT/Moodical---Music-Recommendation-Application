//package Processors;
//import Entities.;
//
//import java.io.;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserRegisterProcessing {
//    public Account account;
//    public File csvOfUsers;
//
//    public void writeAccountToCSV() {
//        BufferedWriter writer;
//        try {
//            writer = new BufferedWriter(new FileWriter(this.csvOfUsers));
//            writer.write("Username, Password, UserHistory, UserFavourites");
//            writer.newLine();
//
//            ArrayList<Song> allHistorySongs = HistoryProcessor.getAllSongs(this.account);
//            String allHistorySongsAsAString = String.valueOf(allHistorySongs);
//            String allFavouritesSongsAsAString = String.valueOf(this.account.userFavourites.getFavourites());
//
//            writer.write(this.account.username);
//            writer.write(this.account.password);
//            writer.write(allHistorySongsAsAString);
//            writer.write(allFavouritesSongsAsAString);
//            writer.newLine();
//
//            writer.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public List<Account> readAccountCSV() throws IOException {
//        List<Account> users = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(this.csvOfUsers)) {
//            String currentLine = reader.readLine();
//            while (currentLine != null) {
//                String[] attributes = currentLine.split(",");
//                Account user = createAccount(attributes);
//                users.add(user);
//                currentLine = reader.readLine();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return users;
//    }
//
//    public Account createAccount(String[] userData) {
//        String username = userData[0];
//        String password = userData[1];
//
//        Song historySongs = new Song();
//        Song favouriteSongs = new Song();
//
//        ArrayList<Song> userHistorySongs = new ArrayList<Song>();
//        userHistorySongs.add(historySongs);
//
//        ArrayList<Song> userFavouriteSongs = new ArrayList<Song>();
//        userFavouriteSongs.add(favouriteSongs);
//
//        History userHistory = new History();
//        Favourites userFavourites = new Favourites();
//
//        return new Account(username, password, userHistory, userFavourites);
//    }
//
//    public Object grabAccount(String username) throws IOException {
//        List<Account> users = readAccountCSV();
//        for (Account user : users) {
//            if (user.username.equals(username)) {
//                return user;
//            }
//        }
//        return "User not found";
//    }
//}