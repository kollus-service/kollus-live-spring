package net.catenoid.se.kolluslive.kollusenum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Scopes {
    CONTROL("live:control"),
    STATISTICS("live:statistics");

    private String scope;

    private Scopes(String value) {
        this.scope = value;
    }


    public static String getScopes(Scopes... scopes) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        if (scopes != null && scopes.length > 0) {

            for (int idx = 0; idx < scopes.length; idx++) {
                stringBuilder.append(scopes[idx].getScope());
                if (idx < scopes.length - 1) {
                    stringBuilder.append(" ");
                }
            }
        } else {
            throw new Exception("Scope 의 값은 NULL일수 없습니다.");
        }
        return stringBuilder.toString();
    }

    public String getScope() {
        return this.scope;
    }
}