public class Symbol {

    private String m_name;
    private int m_level;
    public Symbol(int level,String name){
        m_name=name;
        m_level=level;
    }

    public String GetName(){
        return m_name;
    }

    public void SetName(String name){
        m_name = name;
    }

    public int GetLevel(){
        return m_level;
    }


}
