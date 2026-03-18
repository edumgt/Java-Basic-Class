package InterfacesAndAbstractionEXERCISES.CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {

    protected int maxSize;

    protected List<String> items;

    protected Collection(){
        items = new ArrayList<>();
        maxSize = 100;
    }
}
