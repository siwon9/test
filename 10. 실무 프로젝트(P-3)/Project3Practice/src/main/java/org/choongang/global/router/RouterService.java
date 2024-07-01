package org.choongang.global.router;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RouterService {

    private final HandlerMappingImpl handlerMapping;
    private final HandlerAdapterImpl handlerAdapter;

    public void route(HttpServletRequest req, HttpServletResponse res) throws IOException {
        List<Object> data = handlerMapping.search(req);
        if(data == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        handlerAdapter.execute(req, res, data);
    }
}
