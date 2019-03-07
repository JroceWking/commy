import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class poolRedis {
    String maxActive="1024";

    String  maxIdle="200";

    String maxWait="1000";

    boolean testOnBorrow=true;

    boolean testOnReturn=true;

    String ip="127.0.0.1";


    int port=6379;

    private static JedisPool pool;
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("redis");//peizhiwenjian
        if (bundle == null) {
            throw new IllegalArgumentException(  //decide is Redis?
                    "[redis.properties] is not found!");
        }

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive(Integer.valueOf(bundle
                .getString("redis.pool.maxActive")));
        config.setMaxIdle(Integer.valueOf(bundle
                .getString("redis.pool.maxIdle")));
        config.setMaxWait(Long.valueOf(bundle.getString("redis.pool.maxWait")));
        config.setTestOnBorrow(Boolean.valueOf(bundle
                .getString("redis.pool.testOnBorrow")));
        config.setTestOnReturn(Boolean.valueOf(bundle
                .getString("redis.pool.testOnReturn")));
        pool = new JedisPool(config, bundle.getString("redis.ip"),
                Integer.valueOf(bundle.getString("redis.port")));
    }

    public static void main(String[] args){

        int maxActive=1024;

        int  maxIdle=200;

        int maxWait=1000;

        boolean testOnBorrow=true;

        boolean testOnReturn=true;

       String ip="127.0.0.1";


        int port=6379;

        Jedis jedis = pool.getResource();
        String keys = "name";

        jedis.set("1","jjjjj");
        String value = jedis.get("1");
        System.out.println(value);
        pool.returnResource(jedis); //shifang

    }
}
