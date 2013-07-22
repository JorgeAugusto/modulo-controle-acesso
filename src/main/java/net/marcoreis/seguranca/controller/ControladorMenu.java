package net.marcoreis.seguranca.controller;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;

@Named
public class ControladorMenu {
  private DefaultMenuModel model;

  @PostConstruct
  public void init() {
    model = new DefaultMenuModel();
    MenuItem menuCadastro = null;
    model.addMenuItem(menuCadastro);
    Submenu menuCadastroUsuario = null;
    model.addSubmenu(menuCadastroUsuario);
    MenuItem menuConsulta = null;
    model.addMenuItem(menuConsulta);
    Submenu menuRest = null;
    model.addSubmenu(menuRest);
  }

  public DefaultMenuModel getModel() {
    return model;
  }
}
