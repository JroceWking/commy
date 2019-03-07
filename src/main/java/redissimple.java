import redis.clients.jedis.Jedis;

public class redissimple {
  public static void main(String[] args){

      Jedis jedis = new Jedis("localhost");

      String keys = "name";
      jedis.set("1","jjjjjjj");
      String value  = jedis.get("1");
      System.out.println(value);

  }

}
