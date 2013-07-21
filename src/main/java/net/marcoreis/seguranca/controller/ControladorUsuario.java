package net.marcoreis.seguranca.controller;

import java.util.ArrayList;
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

@Model
public class ControladorUsuario {
  @Inject
  private FacesContext facesContext;
  @Inject
  private FachadaUsuario usuarioRegistration;
  @Produces
  @Named
  private Usuario usuario;
  @Named
  private Collection<Usuario> usuarios;

  @PostConstruct
  public void initInstance() {
    usuario = new Usuario();
    usuarios = new ArrayList<Usuario>();
  }

  //FIXME Criar uma classe para adicinar mensagens no JSF
  public void persistir(Usuario usuario) {
    try {
      usuarioRegistration.persistir(usuario);
      FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação",
          "Dados gravados com sucesso");
      facesContext.addMessage(null, m);
      initInstance();
    } catch (Exception e) {
      FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR,
          e.getLocalizedMessage(), "Erro ao gravar");
      facesContext.addMessage(null, m);
    }
  }
}
