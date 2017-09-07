package sv.edu.tpi.clinica.visual.controller;

import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class BasicLazyDataModel<T> extends LazyDataModel<T> {

    private List<T> data;
    private BaseController<T> controller;

    public BasicLazyDataModel(BaseController<T> controller) {
        this.controller = controller;
    }

    @Override
    public Object getRowKey(T object) {
        return controller.getIdObjeto(object);
    }

    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        this.setRowCount(controller.getCountObjetos());
        data = controller.findRange(getLimites(first, pageSize));
        return data;
    }

    private int[] getLimites(int first, int pageSize) {
        return new int[]{first, pageSize + first};
    }

    @Override
    public T getRowData(String rowKey) {
        return data.stream()
                .filter(object -> controller.isIdDelObjeto(rowKey, object))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
}
