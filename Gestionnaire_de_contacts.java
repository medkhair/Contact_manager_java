import java.util.Scanner;
class contact{
	private String name, number,adress;
	public contact(String na,String nu,String a){
		this.name = na;
		this.number = nu;
		this.adress = a;
	}
	public void setName(String n){
		this.name = n;
	}
	public void setNumber(String n){
		this.number = n;
	}
	public void setAdress(String a){
		this.adress = a;
	}
	public String getName(){
		return this.name;
	}
	public String getNumber(){
		return this.number;
	}
	public String getAdress(){
		return this.adress;
	}
}
class contactApp{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int d = 0;
		contact[] c = new contact[100000];
		for (int i = 0; i < c.length; i++) {
    		c[i] = new contact("", "", "");
		}
		int choix;
		do {
			System.out.println("-------------------------------------");
            System.out.println("\t Menu Principal:");
            System.out.println("\t 1. Afficher tous les conatcts");
            System.out.println("\t 2. Rechercher un contact");
            System.out.println("\t 3. ajouter un contact");
            System.out.println("\t 4. supprimer un contact");
            System.out.println("\t 0. Quitter");
            System.out.print("\t Entrez votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------");
            switch (choix) {
                case 1:
                    afficher(c,d);
                    break;
                case 2:
                    rechercher(c,d);
                    break;
                case 3:
                    ajouter(c,d);
                    d++;
                    break;
                case 4:
                    supprimer(c,d);
                    d--;
                    break;
                case 0:
                    System.out.println("\t Merci d'avoir utilise le gestionnaire de contact. Au revoir !");
                    break;
                default:
                    System.out.println("\t Choix invalide. Veuillez reessayer.");
            }
        }while (choix != 0);
	}
	static void ajouter(contact[] c, int d){
		if (d < c.length) {
		c[d+1] = new contact("name","number","adress");
		Scanner sc = new Scanner(System.in);
		System.out.print("\t Donner le nom : ");
		c[d].setName(sc.nextLine());
		System.out.print("\t Donner le numero : ");
		c[d].setNumber(sc.nextLine());
		System.out.print("\t Donner l'adresse : ");
		c[d].setAdress(sc.nextLine());
		d++;
    	}else{
        System.out.println("Le tableau est plein. Impossible d'ajouter un nouveau contact.");
    	}

	}
	static void afficher(contact[] c, int d){
		if (d == 0){
			System.out.println("\t il y a aucun contact");
		}else{
			System.out.println("\t nombre de contacts : "+ (d));
			for (int i = 0;i < d;i++) {
				System.out.println("\t"+(i+1)+"-/ Le nom est : "+c[i].getName()+" / le numero est : "+c[i].getNumber()+" / l'adresse est : "+c[i].getAdress());
			}
		}		
	}
	static void rechercher(contact[] c, int d){
		String num;
		int choix;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("-------------------------------------");
            System.out.println("\t Menu de recherche:");
            System.out.println("\t 1. chercher par numero");
            System.out.println("\t 2. chercher par nom");
            System.out.println("\t 0. <- Retour");
            System.out.print("\t Entrez votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------");
            switch (choix) {
                case 1:
                	if (d == 0) {
                		System.out.println("il y a aucun contact");
                	}else{
                		System.out.print("\t Entrez Le numero : ");
                		num = sc.nextLine();
                		for (int i=0;i<c.length;i++) {
							if (num.equals(c[i].getNumber())) {
								System.out.println("\t le nom est : "+c[i].getName());
								break;
							}
							if ((!(num.equals(c[i].getNumber()))) && i==(c.length-1)) {
								System.out.println("\t ce numero n'existe pas  ");
							}
						}
                	}                    			
                    break;
                case 2:
                    if (d == 0) {
                		System.out.println("il y a aucun contact");
                	}else{
                		System.out.print("\t Entrez Le nom : ");
                		num = sc.nextLine();
                		for (int i=0;i<c.length;i++) {
							if (num.equals(c[i].getName())) {
								System.out.println("\t le numero est : "+c[i].getNumber());
								break;
							}
							if ((!(num.equals(c[i].getName()))) && i==(c.length-1)) {
								System.out.println("\t ce nom n'existe pas  ");
							}
						}
                	}
                    break;
                case 0:
                	break;
                default:
                    System.out.println("\t Choix invalide. Veuillez reessayer.");
            }
        }while (choix != 0);
	}
	static void supprimer(contact[] c, int d){
		String num;
		int choix;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("-------------------------------------");
            System.out.println("\t Menu de supression:");
            System.out.println("\t 1. supprimer");
            System.out.println("\t 0. <- Retour");
            System.out.print("\t Entrez votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------");
            switch (choix) {
                case 1:
                	afficher(c,d);
                	System.out.println("\t Quel contact voulez vous supprimer ?");
					System.out.print("\t Entrez votre choix : ");
		    		int k1 = (sc.nextInt());
                	for (int i=k1;i<d ;i++ ) {
                		c[i]=c[i+1];
                	}
                	d--;
                	System.out.println("\t après la suppression");
		        	System.out.println("--------------------------------");
		        	afficher(c, d);                   			
                    break;
                case 0:
                	break;
                default:
                    System.out.println("\t Choix invalide. Veuillez reessayer.");
            }
        }while (choix != 0);
	}
}