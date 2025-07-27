public class climatempo {
  public static void main(string[] args){
    Scanner scanner = new Scanner (System.in);
    System.out.print("Digite o nome da cidade: ");
    String cidade = scanner.nextLine(); //Lê o teclado


  Try {
      String dadosClimaticos = getDadosClimaticos(cidade); //retorna um JSON
// O código 1006 significa localização não encontrada.
    if (dadosClimaticos.contains("\"code\":1006")) {// \"code":1006 representa "code": 1006
      System.out.println("Localização não encontrada. Por favor, tente novamente.");
    }else{
      imprimirDadosClimaticos(dadosClimaticos):;

    }
    
      } catch (Exception e){
      System.out.println(e.getMessage());
      }

    }
}
