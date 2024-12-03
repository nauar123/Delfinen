  import java.time.LocalDate;
  import java.util.ArrayList;
  import java.util.Random;

  public class MedlemsOversigt {

      protected ArrayList<Medlem> medlemmereOversigt;
      protected Restance restance;

      public MedlemsOversigt() {
          medlemmereOversigt = new ArrayList<>(); // Initialiserer listen
          createMedlemmereOversigt();
          this.restance = restance;
      }

      public Restance getRestance()
      {
          return restance;
      }

      public ArrayList<Medlem> getMedlemmerOversigt() {
          return medlemmereOversigt;
      }

      public void createMedlemmereOversigt() {
          Random random = new Random();

          // Navnelister
          String[] drengeNavne = {
                  "Peter", "Søren", "Jens", "Thomas", "Anders", "Frederik", "Christian", "Lars", "Hans", "Ole",
                  "Mikkel", "Jacob", "Benjamin", "Mathias", "Emil", "David", "Victor", "Daniel", "Andreas", "Nicklas"
          };
          String[] pigeNavne = {
                  "Anna", "Maria", "Karin", "Mette", "Emma", "Nina", "Camilla", "Louise", "Sofie", "Helle",
                  "Maja", "Lise", "Line", "Katrine", "Helena", "Sarah", "Julie", "Carina", "Laura", "Hanne", "Cecilie"
          };
          String[] efternavne = {
                  "Jensen", "Nielsen", "Hansen", "Pedersen", "Andersen", "Christensen", "Sorensen", "Larsen",
                  "Rasmussen", "Madsen", "Poulsen", "Olsen", "Mikkelsen", "Jørgensen", "Kjær", "Johansen", "Berg", "Buhl"
          };

          // Generer 250 medlemmer
          for (int i = 1; i <= 250; i++) {
              String fornavn;
              boolean erDreng = random.nextBoolean();

              // Vælg fornavn baseret på køn
              if (erDreng) {
                  fornavn = drengeNavne[random.nextInt(drengeNavne.length)];
              } else {
                  fornavn = pigeNavne[random.nextInt(pigeNavne.length)];
              }

              // Generer resten af oplysningerne
              String efternavn = efternavne[random.nextInt(efternavne.length)];
              String navn = fornavn + " " + efternavn;


             CPR cpr = new CPR(true);
             int tlfNr = 10000000 + random.nextInt(90000000); // Generer et tilfældigt 8-cifret telefonnummer
              String mail = fornavn.toLowerCase() + random.nextInt(2222) + "@gmail.com";
              LocalDate oprettelsesDato = LocalDate.now().minusDays(random.nextInt(365 * 5));
              boolean erAktiv = random.nextBoolean();
              boolean erMotionist = random.nextBoolean();
              int medlemsId = 1000 + i;
              boolean restance = random.nextBoolean();


              // Tilføj medlem til listen
              medlemmereOversigt.add(new Medlem(navn, mail, tlfNr, cpr, oprettelsesDato, medlemsId, erAktiv, erMotionist,new Betalinger(), restance));
          }
      }

      public void addMedlemmerToMedlemmere(Medlem m) {
          medlemmereOversigt.add(m);
      }

      public int getAntalMedlemmer() {
          return medlemmereOversigt.size();
      }

       //Hvert medlem (medlemmerOversigt.get(i)) bliver tilføjet til StringBuilder med et linjeskift efter hver post.
      public String toString() {
          StringBuilder sb = new StringBuilder("Medlemmere:\n\n");
          for (int i = 0; i < medlemmereOversigt.size(); i++) {
              sb.append(medlemmereOversigt.get(i).toString());
          }
          return sb.toString();
      }

      public void addAlleMedlemmeretoRestanceList() {
          for (Medlem m : medlemmereOversigt) {
              if (m.erRestance) {
                  restance.addMedlemToRestance(m);
                  System.out.println("Added to RestanceListe: " + m.getNavn());
              }
          }
      }
  }
