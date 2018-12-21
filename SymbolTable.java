import java.util.ArrayList;

public class SymbolTable {

    public ArrayList<Symbol> symbolList = new ArrayList<>();
    public ArrayList<FunSymbol> funSymbolList = new ArrayList<>();

    public void clearList(){
        symbolList.clear();
        funSymbolList.clear();
    }

    public void registerSymbol(Symbol symbol) throws Exception {
        for(int i=0;i<symbolList.size();i++){
            if(symbolList.get(i).GetName()==symbol.GetName()
            && symbolList.get(i).GetLevel()==symbol.GetLevel()){
                throw new Exception(symbol.GetName()+" has been declared");
            }
        }
        symbolList.add(symbol);
    }

    public void registerFunSymbol(FunSymbol funSymbol) throws Exception{
        for(int i=0;i<funSymbolList.size();i++){
            if(funSymbolList.get(i).GetName()==funSymbol.GetName()){
                throw new Exception(funSymbol.GetName()+" function has been declared");
            }
        }
        funSymbolList.add(funSymbol);
    }

    public void deregisterSymbol(int level){
        while(!symbolList.isEmpty()&&symbolList.get(symbolList.size()-1).GetLevel()==level)
            symbolList.remove(symbolList.size()-1);
    }

    public Symbol getSymbol(String name) throws Exception {
        for(int i=symbolList.size()-1;i>=0;i--){
            Symbol tmp = symbolList.get(i);
            if(tmp.GetName()==name)
                return tmp;
        }
        throw new Exception(name+" has not been declared");
    }

    public FunSymbol getFunSymbol(String name) throws Exception{
        for(int i=0;i<funSymbolList.size();i++){
            FunSymbol tmp = funSymbolList.get(i);
            if(tmp.GetName()==name)
                return tmp;
        }
        throw new Exception(name+" function has not been declared");
    }
}
