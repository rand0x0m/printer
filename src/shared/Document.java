package shared;

import client.Observable;

import java.io.File;
import java.rmi.Remote;

public abstract class Document implements Iterable<Page>, Observable, Remote {

    protected File file;
    protected String name;

    protected Document(File file) {
        super();
        this.file = file;
        this.name = file.getName();
    }

    @Override
    public String getName() {
        return this.name;
    }

    protected abstract int size();
}
