package net.marcoreis.seguranca.controller;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import net.marcoreis.seguranca.model.Usuario;
import net.marcoreis.seguranca.service.FachadaUsuario;
import net.marcoreis.seguranca.util.UtilExcecao;

@Model
public class ControladorUsuario {
  @Inject
  private FacesContext facesContext;
  @Inject
  private FachadaUsuario fachadaUsuario;
  @Produces
  @Named
  private Usuario usuario;

  @PostConstruct
  public void initInstance() {
    usuario = new Usuario();
  }

  public Collection<Usuario> getUsuarios() {
    return fachadaUsuario.findAll();
  }

  //FIXME Criar uma classe para adicinar mensagens no JSF
  public void persistir() {
    try {
      fachadaUsuario.persistir(usuario);
      FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
          "Dados gravados com sucesso", "Sucesso");
      facesContext.addMessage(null, m);
      initInstance();
    } catch (Exception e) {
      FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR,
          UtilExcecao.getRootErrorMessage(e), "Erro ao gravar");
      facesContext.addMessage(null, m);
    }
  }

  public void excluir(Usuario u) {
    fachadaUsuario.excluir(u);
  }
}
